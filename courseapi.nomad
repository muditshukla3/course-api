job "courseapi" {

  datacenters = ["dc1"]

  type = "service"

  update {
    stagger      = "30s"
    max_parallel = 1
  }

  group "api" {
     count = 1

    network {
      port "http" {
        static = 8080
        to = 8080
      }
    }

     task "apiservice" {

       driver = "docker"

       config {
         image = "muditshukla3/courseapi:0.0.1-RELEASE"
         ports = ["http"]
       }

     }
  }
}