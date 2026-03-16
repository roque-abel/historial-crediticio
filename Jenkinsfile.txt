pipeline {
    agent any
    tools {
        maven 'Maven-3.8.7'  // nombre de la instalación de Maven en Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/roque-abel/historial-crediticio.git'
              
            }
        }

        stage('Build & Package') {
            steps {
                // Limpia, compila y genera el .jar listo para producción
                sh 'mvn clean package -DskipTests=false'
            }
        }

        stage('Test') {
            steps {
                // Ejecuta los tests unitarios (si no los ejecutaste en package)
                sh 'mvn test'
            }
        }
    }

    post {
        success {
            // Guarda el .jar generado como artefacto de Jenkins
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}