
String pipelinescript = "_jenkins/PipelineResult.groovy"

node{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work


           def PipelineResult = load pipelinescript

           result = new  com.bcmc.xor.PipelineResult()
           result.setScript(this)
           result.success("test","test")
           result.print()
       }
}
