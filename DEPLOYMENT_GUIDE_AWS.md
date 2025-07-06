# 🚀 Deploy Cow Management System to AWS

## 1. Prerequisites
- AWS EC2 (Ubuntu or Amazon Linux)
- Docker and Docker Compose

## 2. SSH and Setup
```bash
sudo apt update
sudo apt install docker.io docker-compose -y
sudo usermod -aG docker $USER
newgrp docker
