cd /usr/share/nginx/html/
chmod 775 env.json
echo $HOST
sed -i -e 's|"replace"|'"$HOST"'|g' env.json
