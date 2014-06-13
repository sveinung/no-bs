# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant::Config.run do |config|
  config.vm.box = "ubuntu-server-1204-x64"
  config.vm.box_url = "http://puppet-vagrant-boxes.puppetlabs.com/ubuntu-server-1204-x64.box"
  
  config.vm.network :hostonly, "10.0.2.11"
  config.vm.forward_port 80, 3000
  config.vm.provision :shell, :path => "infrastructure/install.sh"
end
