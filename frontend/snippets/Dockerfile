FROM node as builder
WORKDIR /src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build --prod
COPY replace-placeholder.sh /src/app/dist/snippets
COPY env.json /src/app/dist/snippets
RUN ls -la /src/app/dist/snippets

FROM nginx:alpine as server
COPY --from=builder /src/app/dist/snippets /usr/share/nginx/html
RUN ./usr/share/nginx/html/replace-placeholder.sh
