
String pipelinescript = "_jenkins/PipelineResult.groovy"
@Library("mylib@v1.0")
import _jenkins.PipelineResult

node{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work



           result = new PipelineResult()
           result.setScript(this)
           result.success("test","test")
           result.print()
       }
}
