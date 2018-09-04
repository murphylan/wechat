ps aux | grep 'wechat-public-account-0.0.1'
kill $(ps aux | grep 'wechat-public-account-0.0.1' | awk '{print $2}')

pgrep -f wechat-public-account-0.0.1-SNAPSHOT.jar | xargs kill

ps aux | grep 'wechat-public-account-0.0.1'
chmod 777 wechat-public-account-0.0.1-SNAPSHOT.jar
nohup java -jar wechat-public-account-0.0.1-SNAPSHOT.jar --server.port=8888 &