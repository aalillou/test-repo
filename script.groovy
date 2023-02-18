def installApp() {
    echo "Installing the application..."
    sh "hostname"
    sh "npm -v"
}
def buildApp() {
    echo "building the application..."
}

def testApp() {
    echo "testing the application..."
}

def buildImage() {
    echo "building the docker image..."
}

def deployApp() {
  echo 'deploying the application...SSH'
}

return this
