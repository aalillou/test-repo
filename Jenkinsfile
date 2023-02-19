#!/usr/bin/env groovy

def gv
def CODE_CHANGES = true

pipeline {

  agent any
  // agent { label 'aws' }

  stages {
    stage('check') {
      when {
        expression {
          //BRANCH_NAME == 'dev' && CODE_CHANGES == true
          CODE_CHANGES == true
        }
      }
      steps {
        echo "GIT_BRANCH:${GIT_BRANCH}"
        sh "node -v"
        sh "npm -v"
        sh "terraform version"
      }
    }
    stage("init") {
      steps {
        script {
          gv = load "script.groovy"
        }
      }
    }

    stage("install") {
      steps {
        script {
          gv.installApp()
        }
      }
    }

    stage("build") {
      steps {
        script {
          gv.buildApp()
        }
      }
    }

    stage("test") {
      steps {
        script {
          gv.testApp()
        }
      }
    }

    stage("deploy") {
      steps {
        script {
          gv.deployApp()
        }
      }
    }
    
  }

  post {
    success { echo "post SUCCES !! :-) " }
    failure { echo "post FAILURE :-( " }
    always { echo "post ALWAYS !!" }
  }
}
