FROM node as builder
ARG HOST
WORKDIR /src
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN ls -la /src
RUN ./replace-placeholder.sh $HOST
RUN echo $HOST + "....................................."
RUN npm run build --prod

FROM nginx:alpine as server
ARG HOST
RUN echo $HOST + "--------------"
COPY --from=builder /src/app/dist/snippets /usr/share/nginx/html
