#!/usr/bin/env groovy


try{
   
	node {
	   stage 'Checkout'
	       echo "check out start"
		   checkout scm
	       echo "check out end"
	   stage 'Clean Test'
	   	  echo "clean test start"
	   	  sh 'mvn clean test'		
	   	  echo "clean test end"
	   stage 'Clean Package'
	   	  echo "clean package start"
	   	  sh 'mvn clean package -Dspring.profiles.active=docker -Dmaven.test.skip'		
	   	  echo "clean package end"
	   stage 'Docker Build'
	   	  echo "docker build start"
	   	  sh 'docker build . -t task'		
	   	  echo "docker build end"
	   stage 'Docker Run'
	   	  echo "docker compose up start"
	   	  sh 'docker-compose up -d'		
	   	  echo "docker compose up end"
	
	}

}catch(ex){
  err = caughtError
  echo "error while building"+err
 /*  mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) failed",
         body: "It appears that ${env.BUILD_URL} is failing, somebody should do something about that",
           to: 'kumar.hv3@gmail.com',
      replyTo: 'kumar.hv3@gmail.com',
       from: 'kumar.hv3@gmail.com'
 */
}finally{
  echo "executing finally block"
  mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) ${currentBuild.result}",
         body: "It appears that ${env.BUILD_URL} ${currentBuild.result}",
           to: 'honnala.c203@gmail.com',
      replyTo: 'kumar.hv3@gmail.com',
 from: 'kumar.hv3@gmail.com'
}



def buildDev(){

	node {
	   stage 'check out and clean'
	       print "check out start"
		   checkout scm
		   sh 'mvn clean'
	       print "check out end"
	   stage 'check out and clean'
	   	  print "clean package start"
	   	  sh 'mvn clean package'
	   	  print "clean package end"
	
	}
}