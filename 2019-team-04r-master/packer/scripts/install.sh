#!/bin/bash

echo "Starting install script..."

# Make .ssh folder
cd /home/vagrant/
mkdir -p .ssh
chmod 700 .ssh
# Add vagrant ssh key
wget --no-check-certificate https://raw.github.com/mitchellh/vagrant/master/keys/vagrant.pub -O /home/vagrant/.ssh/authorized_keys
# Set proper permission on folder
chmod 700 .ssh/authorized_keys
chown -R vagrant:vagrant /home/vagrant/
# Allow vagrant to run sudo
sudo echo "vagrant ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers
