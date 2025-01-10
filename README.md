# Kafka-Learn-MS-SpringBoot


# Apache Kafka Setup Guide

## **->Download and Setup Kafka**

### **Steps to Download and Setup Kafka**
1. Go to the official site of [Apache Kafka](https://kafka.apache.org/).
2. Navigate to:
    - **Navigation Bar** → **Get Started** → **Quick Start** → **Download**.
3. Download the `kafbat-ui-v1.0.0.jar` to start using **KRaft**.
    - Command to download the jar: [Kafbat UI Jar Download](https://ui.docs.kafbat.io/development/building/without-docker).
    - Hit the above link and download the `kafbat-ui.jar` file.
4. Place the `kafbat-ui.jar` file in the Kafka folder.
5. Create an `application-local.yml` file and configure it as required.
6. Place the `application-local.yml` file in the Kafka folder.
7. Execute the Kafbat UI jar file with the following command:
   ```bash
   java -Dspring.config.additional-location=application-local.yml --add-opens java.rmi/javax.rmi.ssl=ALL-UNNAMED -jar kafbat-ui-v1.0.0.jar



## **->Start Kafka Server Using KRaft**

### **Steps to Run Kafka Server and Check in UI**

> **Note:** This tutorial does not use Zookeeper to manage brokers. Instead, we use **KRaft**.

1. **Generate a unique Kafka Cluster ID:**
   ```bash
   KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
2. **Run Kraft for Kafka Server:**
   ```bash
   bin/kafka-storage.sh format --standalone -t $KAFKA_CLUSTER_ID -c config/kraft/reconfig-server.properties 
3. **If you encounter an error**
   ```bash
   Exception in thread "main" java.lang.RuntimeException: Invalid cluster.id in: /tmp/kraft-combined-logs/meta.properties
4.  **Set the previous KAFKA_CLUSTER_ID using**
    ```bash
    KAFKA_CLUSTER_ID=<previous_UUID>
5. **Start the Kafka server:**
   ```bash
   bin/kafka-server-start.sh config/kraft/reconfig-server.properties



## **->Start Kafbat UI**

### **Steps to Run Kafbat UI**
1. Run the following command to start the Kafbat UI server:
   ```bash
   java -Dspring.config.additional-location=application-local.yml --add-opens java.rmi/javax.rmi.ssl=ALL-UNNAMED -jar kafbat-ui-v1.0.0.jar
2.  **If you Access kafbat UI Hit LocalHost**
    ```bash
    http://localhost:8080


## **->Run Kafka Server with Zookeeper If Not Using Kraft**

### **Steps to Start Kafka Server with Zookeeper**

If you are not using KRaft, follow these steps to start Kafka with Zookeeper:

1. **Start the Zookeeper server:**
   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
2. **Start the Kafka server:**
   ```bash
   bin/kafka-server-start.sh config/server.properties
3. **Consume messages from a topic: READ a Topic Message**
   ```bash
   bin/kafka-console-consumer.sh --topic <TOPIC_NAME> --from-beginning --bootstrap-server localhost:9092



