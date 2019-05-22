# 2019-team-04r
Private team repo for ITMT 430
# QuadRangle

![QRLogo](diagrams/quadranglelogov5.png "QuadRangle logo")

## Team Members
* Brigette Mora
* Isabel Jaramillo
* Deborah Barndt
* Erick Cruz
* Martae Marshall
* David Delgado

## Overview
The QuadRangle app is a central community engagement application that allows users (students, faculty, and staff) to be able to discuss  various topics surrounding campus actives. The idea is to have a main feed once they log in, but they'll have a dashboard where they can enter specific subgroups such as Events, Foodie, Transportation, etc. Additionally, users will have the opportunity to create and vote on incidents or requests that can further improve their community.


## Features
* Participate in various subgroups.
* Create discussion posts that can be labeled/categorized for easier searching/grouping.
* Create incident posts that contain details about an incident and that provides progress tracking in addition to being able to “+1” the incident to provide your support.
* Create request posts for other members to comment and refine the request in addition to being able to “+1” the request to provide your support.
* Dashboard/Sidebar that shows most popular discussions, incidents, and requests.

## Build Instructions: Use vagrant to launch app environment

### Prerequisites
* You will need [Vagrant](https://www.vagrantup.com/intro/getting-started/install.htmlhttps://www.vagrantup.com/intro/getting-started/install.html) installed

* You will need [VirtualBox](https://www.virtualbox.org/) installed

* You will need to generate and add your own deploy key to the GitHub repository.
Perform the following steps:
1. Navigate to this repository on your shell
2. Create an ssh key `ssh-keygen -t rsa -b 4096 -C "youremail@example.com"`
3. When prompted to enter a file, make sure you enter `deploy`
4. When prompted to enter a passphrase, leave empty for no passphrase
5. Run `ls` to confirm you see `deploy` and `deploy.pub`
6. Copy the contents of your `deploy.pub`
7. Go to `https://github.com/illinoistech-itm/2019-team-04r/settings/keys`
8. Select "Add deploy key"
9. Title the key with your name and paste the contents of `deploy.pub` into the Key field

### How to use
1. Navigate to the vagrant folder `cd /vagrant`
2. Make sure you have ubuntu/xenial64 by doing `vagrant box list`. If you do not have it, you can run `vagrant box add ubuntu/xenial64`
3. Run `vagrant up` to start building the virtual machine
4. Vagrant creates the VM and provisions it to run our application
5. Run `vagrant ssh` to remote into the VM
6. Navigate to the repo folder in the VM box `cd ~/2019-team-04r`
7. Run `./launch_app.sh`
8. Copy the URL into your browser and select your iit.edu account
9. Allow Firebase CLI to access Google Acount.
10. Once the server is running, go to `http://localhost:5000` to visit the web application

