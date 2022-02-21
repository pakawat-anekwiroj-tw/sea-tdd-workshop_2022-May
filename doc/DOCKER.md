# Docker Setup
without Docker Desktop

## Instructions

- Install Minikube + Hyperkit + Docker + Docker-compose

```bash
# Install hyperkit and minikube
brew install hyperkit
brew install minikube

# Install Docker CLI
brew install docker
brew install docker-compose

# Start minikube
minikube start

# Tell Docker CLI to talk to minikube's VM
eval $(minikube docker-env)

# Save IP to a hostname
echo "`minikube ip` docker.local" | sudo tee -a /etc/hosts > /dev/null

# Test
docker run hello-world
```

# Potential Errors

### Docker daemon not started

- `minikube status` should indicate `docker-env: in-use`. If not run `eval $(minikube -p minikube docker-env)`
- `minikube start`

### Creating Hyperkit failed: Couldn’t create IP address

- uninstall VM if already present on the computer before
- `minikube delete`
- `rm -rf ~/.minikube`
- reinstall Hyperkit

### exec: "docker-credential-desktop": executable file not found in $PATH, out: ``

The fix is to change the `~/.docker/config.json` .

Remove the extra “s” from `credsStore`, to get:

```kotlin
{
  "experimental" : "disabled",
  "auths" : {

  },
  "credStore" : "desktop"
}
```