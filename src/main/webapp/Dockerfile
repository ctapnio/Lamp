# Use an official Node runtime as a parent image
FROM node:latest as builder
RUN mkdir -p /app
# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . .

# Install Angular CLI
RUN npm install -g @angular/cli

# Install app dependencies
RUN npm install

# Build the Angular app
RUN ng build --prod

# Start Nginx server
# CMD ["npm", "start"]

FROM nginx:alpine
COPY /nginx/etc/conf.d/default.conf /etc/conf.d/default.conf

COPY --from=builder webapp/dist/webapp usr/share/nginx/html

