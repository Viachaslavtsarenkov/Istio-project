FROM node:current-alpine as build
WORKDIR /app
COPY package*.json ./
ENV CI=true
RUN npm install
COPY . .
RUN npm run build
FROM nginx
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80