FROM node:current-alpine as build
WORKDIR /ui-service
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx
COPY --from=build /ui-service/build /usr/share/nginx/html
EXPOSE 80