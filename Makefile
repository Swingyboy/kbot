APP=$(shell basename $(shell git remote get-url origin))
VERSION=$(shell git describe --tags --abbrev=0)-$(shell git rev-parse --short HEAD)
OWNER=swingyboy
TARGETOS=linux
TARGETARCH=amd64

format:
	gofmt -s -w ./

lint:
	golint

test:
	go test -v

get:
	go get

build: format get
	CGO_ENABLED=0 GOOS=${TARGETOS} GOARCH=${TARGETARCH} go build -v -o kbot -ldflags "-X="github.com/Swingyboy/kbot/cmd.appVersion=${VERSION}

image:
	docker build . --tag ${OWNER}/${APP}:${VERSION}-${TARGETOS}-${TARGETARCH}

image_ghcr:
	docker build . --tag ghcr.io/${OWNER}/${APP}:${VERSION}-${TARGETOS}-${TARGETARCH}

push:
	docker push ${OWNER}/${APP}:${VERSION}-${TARGETOS}-${TARGETARCH}

push_ghcr:
	docker push ghcr.io/${OWNER}/${APP}:${VERSION}-${TARGETOS}-${TARGETARCH}

clean:
	rm -rf kbot
	docker rmi ${OWNER}/${APP}:${VERSION}-${TARGETOS}-${TARGETARCH}