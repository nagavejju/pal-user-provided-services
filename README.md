Working with User Provided Services
===


User provided services allow your application running on PCF  to connect
to backing services that are not running on PCF. For example, if you have
an existing database that your Spring app needs to connect to, you could
bind a user provided service instance to your application with the database's
connection credentials so the app can connect to it. Similar to regular
service bindings, the credentials you specify will be available via
`VCAP_SERVICES`.

In this lab you will leverage a user provided service to connect to a
MySQL database running on RDS.  Once you have connected, you'll write a
simple UI that lists data from a table in the database.


Lab
-----


1. Fork this lab
1. Clone it to your workspace
1. Get it working locally
1. Push the app to PCF

1. Modify the app to read your names from a database with a table called _cohort_ and a column called names.
1. Display them on the start page
1. Create a [user provided service](https://docs.cloudfoundry.org/devguide/services/user-provided.html) that exposes the credentials for our external database via VCAP_SERVICES
1. Bind that service to the app
1. Push your app to PCF