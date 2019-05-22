#!/usr/bin/env bash

echo "Hello, my home directory is: $HOME"

# Update apt repository
sudo apt-get update

# Install nvm
export NVM_DIR="/home/vagrant/.nvm" && (
  git clone https://github.com/creationix/nvm.git "$NVM_DIR"
  cd "$NVM_DIR"
  git checkout `git describe --abbrev=0 --tags --match "v[0-9]*" $(git rev-list --tags --max-count=1)`
) && \. "$NVM_DIR/nvm.sh"

echo 'export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" # This loads nvm' >> /home/vagrant/.bashrc

chown -R vagrant /home/vagrant/.nvm/

# Install node v11.* and npm v6.*
nvm install 11
nvm use 11

# Install Firebase Tool
npm install firebase-tools -g

# Setup ssh folder
mkdir -p /home/vagrant/.ssh
# Set correct permissions for ssh folder
chmod -R 700 /home/vagrant/.ssh
# Set correct ownership for ssh folder
chown -R vagrant:vagrant /home/vagrant/
# Add github.com to known hosts
ssh-keyscan -H github.com >> /home/vagrant/.ssh/known_hosts
ssh-keyscan -H github.com >> ~/.ssh/known_hosts

# Copy repo
su -c 'cd /home/vagrant; git clone git@github.com:illinoistech-itm/2019-team-04r.git' - vagrant
chown -R vagrant:vagrant /home/vagrant/2019-team-04r
chmod +x /home/vagrant/2019-team-04r/launch_app.sh
cd '/home/vagrant/2019-team-04r/q_app_final/quad_app/web-start/functions'
npm install

#npm install -g mern-cli
#npm install
#npm start

