# stage 1
FROM node:latest as node-app
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

# stage 2
FROM nginx:alpine
COPY --from=node-app /app/dist/angular-src /usr/share/nginx/html

# Step 3
# run "command docker build -t angular ." on terminal
# run "command docker run --rm -p 80:80 angular" on terminal