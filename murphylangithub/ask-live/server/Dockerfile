### STAGE 1: Build ###

# We label our stage as 'builder'
FROM node:8-alpine as builder

WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

COPY . .

CMD [ "npm", "run", "start-auth" ]