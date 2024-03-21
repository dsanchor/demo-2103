# Spring Boot REST API Demo

## Compilación

Para compilar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn clean install
```

## Ejecución

Para ejecutar el proyecto se debe ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

## Test operación hello con curl

```bash
curl http://localhost:8080/hello
```

## Test operación reverse con curl

```bash
curl http://localhost:8080/reverse?input=world
```

## Test operación removeVowels con curl

```bash
curl http://localhost:8080/removeVowels?input=world
```

## Ejecución de test unitarios

Para ejecutar los test unitarios se debe ejecutar el siguiente comando:

```bash
mvn test
```

## Containerización

### Contruir imagen Docker

Para construir la imagen Docker se debe ejecutar el siguiente comando:

```bash
docker build -t api-demo .
```

### Ejecutar contenedor Docker

Para ejecutar el contenedor Docker se debe ejecutar el siguiente comando:

```bash
docker run -p 8080:8080 api-demo
```

## Desplegar en AKS (Azure Kubernetes Service)

### Variables de entorno

```bash
export RESOURCE_GROUP=aks-demo-alb-rg
export CLUSTER_NAME=demo
export NAMESPACE=demobankinter
```

### Obtener credenciales del cluster

```bash
az aks get-credentials --resource-group $RESOURCE_GROUP --name $CLUSTER_NAME
```

### Crear namespace

```bash
kubectl create namespace $NAMESPACE
```

### Desplegar aplicación

```bash
kubectl apply -f k8s/application.yaml -n $NAMESPACE
```

### Obtener la ip pública del balanceador de carga

```bash
export SVC_IP=$(kubectl get svc api-demo-service -n $NAMESPACE -o jsonpath='{.status.loadBalancer.ingress[0].ip}')
```

### Test operación hello con curl

```bash
curl http://$SVC_IP/hello
```