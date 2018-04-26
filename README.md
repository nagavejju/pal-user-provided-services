Working with User Provided Services
===


User provided services allow your application running on PCF  to connect
to backing services that are not running on PCF. For example, if you have
an existing database that your Spring app needs to connect to, you could
bind a user provided service instance to your application with the database's
connection credentials so the app can connect to it. Similar to regular
service bindings, the credentials you specify will be available via
`VCAP_SERVICES`.

In this lab you will leverage a user provided service to connect to an
Oracle database running on RDS.  Once you have connected, you'll write a
simple UI that lists data from a table in the database.


Lab
-----


1. Fork the lab on [GitHub](https://github.com/platform-acceleration-lab/pal-user-provided-services)
1. Get it working locally
1. Create a user provided service binding
1. Push your app to PCF