def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t blaqsmyth/demo-app:jma-4.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push blaqsmyth/demo-app:jma-4.0'
    }
}