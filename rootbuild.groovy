
String pipelinescript = "_jenkins/PipelineResult.groovy"

pipeline{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work


           def result = load pipelinescript

           result.success("test","test")
           result.print()
       }
}
