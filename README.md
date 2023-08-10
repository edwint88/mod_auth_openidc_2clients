# mod_auth_openidc_2clients
Demo for mod_auth_openidc with two keycloak clients

## install mod_auth_openidc in the httpd image

`apt-get update && apt-get install --no-install-recommends -y ca-certificates libapache2-mod-auth-openidc`

## add my ip to /etc/hosts

`myIp(192.178.1.25) wet.devlop.de`

## Keystore.p12
The super secret password for this demo is: test1234

## Import realms (per hand)

enter the keycloak container
`docker exec nameYourKeycloakContainer sh`

copy the realm files in the container (or make a volumen out of it)
`docker cp ./keycloak/dc-realm.json nameYourKeycloakContainer:/tmp`

run the import script
`/opt/keycloak/bin/kc.sh import --file /tmp/dc-realm.json --override true`

## docker run example
`docker run -di --name kc -p 8787:8787 -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e DEBUG_PORT="*:8787" -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.1 --debug start-dev`

# for VHosts implementation check the vhost branch