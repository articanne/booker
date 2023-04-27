# Base stage
FROM node:14 AS base
WORKDIR /app
COPY package*.json ./
RUN npm install

# Build stage
FROM base AS build
COPY . .
RUN npm run build

# Test stage
FROM base AS test
COPY --from=build /app/build /app/build
RUN npm test

# Production stage
FROM node:14-alpine AS production
COPY --from=build /app/build /app/build
EXPOSE 3000
CMD ["npm", "start"]
