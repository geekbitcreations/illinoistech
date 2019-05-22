# Vagrant to launch app environment

## Prerequisites
* You will need [Vagrant](https://www.vagrantup.com/intro/getting-started/install.htmlhttps://www.vagrantup.com/intro/getting-started/install.html) installed

* You will need [VirtualBox](https://www.virtualbox.org/) installed

* You will need to generate and add your own deploy key to the GitHub repository.
Perform the following steps:
1. Navigate to the repository on your shell `cd ~/SOMEPATH/2019-team-04r`
2. Create an ssh key `ssh-keygen -t rsa -b 4096 -C "youremail@example.com"`
3. When prompted to enter a file, make sure you enter `deploy`
4. When prompted to enter a passphrase, leave empty for no passphrase
5. Run `ls` to confirm you see `deploy` and `deploy.pub`
6. Copy the contents of your `deploy.pub`
7. Go to `https://github.com/illinoistech-itm/2019-team-04r/settings/keys`
8. Select "Add deploy key"
9. Title the key with your name and paste the contents of `deploy.pub` into the Key field

## How to use
1. Navigate to the vagrant folder `cd somepath/2019-team-04r/vagrant`
2. Make sure you have ubunut/Xenial64 by doing `vagrant box list`. If you do not have it, you can `vagrant box add ubuntu/xenial64` 
3. Run `vagrant up`
4. Vagrant should create the VM and provision it to run our application

- You should be able to access ports [8000](127.0.0.1:8000) and [27017](127.0.0.1:27017) outside of the VM
- CAUTIOUS: Please halt the VM once done using - `vagrant halt`

## Troubleshooting
- If your port is being used, go into the Vagrantfile and adjust the ports to a port that isn't be used from 27017
- You can list all active connections with ports by going into Command Prompt and typing `netstat -aon | findstr 27017`. This will display the PID of what is using this port.
- Common applications that use 27017 - MongoDB or xampp

