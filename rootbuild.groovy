
String pipelinescript = "_jenkins/PipelineResult.groovy"

node{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work


           PipelineResult PipelineResult = load pipelinescript

           result = PipelineResult()
           result.setScript(this)
           result.success("test","test")
           result.print()
       }
}
