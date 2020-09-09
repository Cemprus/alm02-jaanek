pipeline{
    agent any
    parameters{
        choice (name: 'DEPLOY_ENV', choices:['int', 'stage', 'test', 'prod'], description:'Target environment')
    }

    stages{
        stage('Build application'){
            agent {
                docker { image 'rasilva1986/java-maven:alm'}
            }
            steps{
                sh 'mvn clean install'
            }
            
            post{
                always{
                    junit 'target/surefire-reports/*.xml'
                    publishHTML([
                        allowMissing: false, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: false, 
                        reportDir: 'target/surefire-reports/', 
                        reportFiles: 'index.html', 
                        reportName: 'Unit tests', 
                        reportTitles: 'Unit tests'
                    ])
                    
                    publishHTML([
                        allowMissing: false, 
                        alwaysLinkToLastBuild: false, 
                        keepAll: false, 
                        reportDir: 'target/site/jacoco/', 
                        reportFiles: 'index.html', 
                        reportName: 'Test coverage', 
                        reportTitles: 'Test coverage'
                    ])
                }


            }

        }

        stage('Deploy application'){
            agent any
            steps{
                sh 'asadmin --port 4848 deploy --force --name assigment-${DEPLOY_ENV} --contextroot assigment-${DEPLOY_ENV} target/assigment-2-0.0.1-SNAPSHOT.war'
            }
        }
    }
}