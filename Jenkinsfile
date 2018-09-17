node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/apaargupta/samplerepoapaar.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'MVN'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean install"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean install/)
      }
   }
   stage('Deploy') {
      //junit '**/target/surefire-reports/TEST-*.xml'
      //archive 'target/*.jar'
      sh "scp -i /C/Users/apaagupt/Downloads/sampleKeyPair.pem -r target/  ec2-user@ec2-18-223-134-239.us-east-2.compute.amazonaws.com:/home/ec2-user"
   }
}