Working with User Provided Services
===


User provided services allow your application running on PCF  to connect
to backing services that are not running on PCF. For example, if you have
an existing database that your Spring app needs to connect to, you could
bind a user provided service instance to your application with the database's
connection credentials so the app can connect to it. Similar to regular
service bindings, the credentials you specify will be available via
[`VCAP_SERVICES`](https://docs.cloudfoundry.org/devguide/deploy-apps/environment-variable.html#VCAP-SERVICES).

In this lab you will leverage a user provided service to connect to a
MySQL database running on Amazon RDS.  Once you have connected, you will write a
simple UI that lists data from a table in the database.


Lab
-----


## Getting Started
1. Fork this lab
1. Clone it to your workspace
1. Get it working locally
1. Push the app to PCF
1. Make sure the app is running correctly

## Have some fun
1. Modify the app to read your names from a database _externaldatabase_ with a table called _cohort_ and a column called name.
1. Display them on the start page
1. Create a [user provided service](https://docs.cloudfoundry.org/devguide/services/user-provided.html) that exposes the credentials for our external database via VCAP_SERVICES
1. Bind that service to the app
1. Read the connection data from the bound user provided service
1. Push your app to PCF
1. Make sure the app is running correctly

## More fun
1. Modify your user provided service so that the spring cloud connector can pick up the credentials automatically
1. Push the app to PCF
1. Make sure the app is running correctly


## Even more fun
1. Write a [task](https://docs.cloudfoundry.org/devguide/using-tasks.html) that writes your and your pair's nickname into the database in a column called _nickname_. Make sure to put it next to your name.
1. Modify the app from above to display _name_ and _nickname_ on the page.