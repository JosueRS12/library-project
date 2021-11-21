FROM node:14-alpine3.12

WORKDIR /app

COPY ["package.json","package-lock.json", "/app/"]

RUN npm install --silent

COPY [".","/app/"]

EXPOSE 3000

CMD ["npm","run","start"]
