// Jenkinsfile - Declarative Pipeline for Android Dev Environment
// This pipeline runs verification, builds, and deploys the Dev flavor

pipeline {
    agent any

    // Environment variables available to all stages
    environment {
        // Android SDK paths
    JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
   ANDROID_HOME = '/var/lib/jenkins/Android/Sdk'
    PATH = "${ANDROID_HOME}/platform-tools:${ANDROID_HOME}/tools:${env.PATH}:${JAVA_HOME}/bin"

    SONAR_HOST_URL = 'http://localhost:9000'
    SONAR_PROJECT_KEY='AndroidProj'
    SONAR_TOKEN = 'sqa_df1f32e2f193c27d017f2619c6963011bb620025'
        // Load credentials from Jenkins
//         KEYSTORE_FILE = credentials('android-keystore-dev')
//         KEYSTORE_PASSWORD = credentials('android-keystore-password-dev')
//         KEY_ALIAS = credentials('android-key-alias-dev')
//         KEY_PASSWORD = credentials('android-key-password-dev')
//         FIREBASE_TOKEN = credentials('firebase-token-dev')


        // Git information
        GIT_COMMIT_SHORT = sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
    }

    // Pipeline options
    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
    }

    // Trigger on develop branch pushes
    triggers {
        pollSCM('H/5 * * * *')  // Poll every 5 minutes
    }

    stages {

        // ==========================================
        // STAGE 1: Setup Environment
        // ==========================================
        stage('Setup') {
            steps {
                echo '📦 Setting up environment...'

                script {
                    // Print build information
                    echo "Branch: ${env.GIT_BRANCH}"
                    echo "Commit: ${env.GIT_COMMIT_SHORT}"
                    echo "Build Number: ${env.BUILD_NUMBER}"
                }

                // Make gradlew executable
                sh 'chmod +x gradlew'

                // Install Fastlane dependencies
                sh 'bundle install --path vendor/bundle'

                // Create env file with credentials
                sh '''
                    cat > fastlane/.env.dev << EOF
APP_NAME=MyApp Dev
PACKAGE_NAME=com.example.myapp.dev
VERSION_NAME=1.0.0

FIREBASE_APP_ID=1:123456789:android:abcdef123456
FIREBASE_TOKEN=${FIREBASE_TOKEN}

KEYSTORE_FILE=${KEYSTORE_FILE}
KEYSTORE_PASSWORD=${KEYSTORE_PASSWORD}
KEY_ALIAS=${KEY_ALIAS}
KEY_PASSWORD=${KEY_PASSWORD}

SONAR_HOST_URL=http://your-sonarqube-server:9000
SONAR_TOKEN=${SONAR_TOKEN}
SONAR_PROJECT_KEY=AndroidProj

GIT_BRANCH=${GIT_BRANCH}
GIT_COMMIT=${GIT_COMMIT_SHORT}
EOF
                '''
            }
        }

        // ==========================================
        // STAGE 2: Run Tests & Verification
        // ==========================================
        stage('Verify') {
            steps {
                echo '🔍 Running verification checks...'

                // Run Fastlane verify lane
                sh 'bundle exec fastlane verify'
            }
//             post {
//                 always {
//                     // Publish test results
//                     junit '**/test-results/**/*.xml'
//
//                     // Publish lint results
//                     recordIssues(
//                         enabledForFailure: true,
//                         tool: androidLintParser(pattern: '**/lint-results-*.xml')
//                     )
//                 }
//             }
        }

        // ==========================================
        // STAGE 3: Code Quality Analysis
        // ==========================================
        stage('Code Quality') {
            steps {
                echo '📊 Running SonarQube analysis...'

                // Run SonarQube scan
                sh 'bundle exec fastlane android sonarqube'
            }
        }



        // ==========================================
        // STAGE 4: Build & Deploy Dev
        // ==========================================
        stage('Build & Deploy') {
            steps {
                echo 'Building and deploying Dev build...'

                // Run Fastlane deploy lane
                sh 'bundle exec fastlane deploy_dev'
            }
            post {
                success {
                    echo '✅ Dev build deployed successfully to Firebase!'
                }
            }
        }
    }

    // ==========================================
    // POST ACTIONS
    // ==========================================
    post {
        success {
            echo '✅ Pipeline completed successfully!'

            // Archive the APK
            archiveArtifacts artifacts: '**/outputs/apk/**/*.apk', fingerprint: true


        }

        failure {
            echo '❌ Pipeline failed!'
            }

        }

}



