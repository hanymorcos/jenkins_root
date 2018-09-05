
String pipelinescript = "_jenkins/PipelineResult.groovy"

node{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work


           def result = load pipelinescript

           result.setOut(getBinding().out)
           result.success("test","test")
           result.print()
       }
}
