cd src/environments/

chmod 775 environment.ts
chmod 775 environment.prod.ts

sed -i -e 's|APIURL|'"$1"'|g' environment.ts
sed -i -e 's|APIURL|'"$1"'|g' environment.prod.ts
