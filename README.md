# K-BOT

Devops application from scratch.

## Examples of .yaml promts

|NAME|PROMPT|DESCRIPTION|EXAMPLE|
|----|------|-----------|-------|
|app|Node Prompt|Creates pod with name "app" and exposes port 8080.|[app.yaml](./yaml/app.yaml)|
|app-livenessProbe|Liveness Probe Prompt|Creates pod with name "app" and exposes port 8080 and add liveness probe|[app-livenessProbe.yaml](./yaml/app-livenessProbe.yaml)|
|app-readinessProbe|Liveness and Readiness Probes Prompt|Creates a pod with name app, 8000 container port expose and liveness probe with path "/" and readiness probe with path "/ready". |[app-readinessProbe.yaml](./yaml/app-readinessProbe.yaml)|
|app-volumeMounts|Volumes|Creates pod with name app, with  kbot:latest image from gcr.io registry and my-kbot project, 8000 container port expose and readiness probe with path "/ready" and volume with name "data" and path "/var/lib/kbot" .|[app-volumeMounts.yaml](./yaml/app-volumeMounts.yaml)|
|app-cronjob|Cron Job Prompt|Creates cronjob for k-bot container and executes "version" command.|[app-cronjob.yaml](./yaml/app-cronjob.yaml)|
|app-job|Job Prompt|Creates a job with nginx server that listens 80 port and writes request body to persistent value.|[app-job.yaml](./yaml/app-job.yaml)|
|app-multicontainer|Prompt for multicontainer pod|Creates pod with two containers: ubuntu and python 3.11 http server.|[app-multicontainer.yaml](./yaml/app-multicontainer.yaml)|
|app-resources|Prompt for pod with resources limitation|Creates pod with k-bot image with requested resources and sets the resource limits.|[app-resources.yaml](./yaml/app-resources.yaml)|
|app-secret-env|Prompt for pod with secrets|Creates pod with redis container and sets the secrets.|[app-secret-env.yaml](./yaml/app-secret-env.yaml)|