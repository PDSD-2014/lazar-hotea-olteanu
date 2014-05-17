lazar-hotea-olteanu
===================

lazar-hotea-olteanu

###Amazon Instance Configuration

**Host**: 54.72.185.**

**User**: CHANGEME

**Password**: CHANGEME

In order to start lampp server use the following command line: **sudo /opt/lampp/lampp start**

Allow Client to connect to remote MySQL Server

GRANT ALL ON pdsd.* to 'user'@'%' IDENTIFIED BY 'password';
FLUSH PRIVILEGES;

Allow Incoming Traffic on Server's Ports :
sudo iptables -A INPUT -p tcp --dport 9999 -j ACCEPT

Allow Outgoing Traffic on Server's Ports :
sudo iptables -A OUTPUT -p tcp --dport 9999 -j ACCEPT


###How to start a client

java -cp ../../json-simple-1.1.1.jar:. com.example.proiectpdsd.Client
