job "milad-nomad-cluster" {
    datacenters = ["fsn"]

    type = "service"

    update {
        max_parallel      = 1
        health_check      = "checks"
        min_healthy_time  = "1m"
        healthy_deadline  = "2m"
        progress_deadline = "10m"
        auto_revert       = true
        auto_promote      = true
        canary            = 1
    }

    group "clusterApp" {
        count = 2

        task "springapp" {
            driver = "docker"

            config {
                image = "docker.registry.com/spring-nomad-cluster:6.10.0-SNAPSHOT"
                force_pull = true
                port_map {
                    backend_http = 9090
                }
            }

            ######################################################
            ############## Elasticsearch Settings ################
            ######################################################
            template {
                destination = "$${NOMAD_SECRETS_DIR}/yghelasticsearch.env"
                env = true
                data = <<EOF
                        {{ range service "milad-elasticsearch-transport|any" }}
                        ELASTICSEARCH_CLUSTER_NODES={{ .Address }}:{{ .Port }}
                        {{ end }}
                        ELASTICSEARCH_CLUSTER_NAME=milad-elasticsearch
                        ELASTICSEARCH_SERVER_CLUSTER_SNIFF=false
                        ELASTICSEARCH_SERVER_CLUSTER_CLIENT=transport
                        ELASTICSEARCH_SERVER_LOCAL_ACTIVE=false
                        EOF
            }

            resources {
                cpu =300
                memory = 1000
                network {
                    mbits = 10
                    port "backend_http" {}
                }
            }

            service {
                port = "backend_http"
                tags = [
                    "traefik.enable=true",
                    "traefik.frontend.rule=Host:milad-cluster-demo.com"
                ]
                check {
//                    type = "http"
                    type = "tcp"
//                    path = "/"
                    interval = "10s"
                    timeout  = "2s"
                }
            }
        }


        task "elastic-search" {
            driver = "docker"

            config {
                image = "docker.elastic.co/elasticsearch/elasticsearch:7.10.0"

                port_map {
                    elastictransport = 9200
                }
            }

            env {
                "xpack.security.enabled" = "false"
                "cluster.name" = "milad-elasticsearch"
                "discovery.type" = "single-node"
            }

            resources {
                cpu = 300
                memory = 3000
                network {
                    mbits = 10
                    port "elastictransport" {}
                }
            }

            service {
                name = "milad-elasticsearch-transport"
                port = "elastictransport"
                check {
                    type = "tcp"
                    interval = "10s"
                    timeout = "2s"
                }
            }
        }
    }
}
