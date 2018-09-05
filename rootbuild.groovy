
String pipelinescript = "_jenkins/PipelineResult.groovy"

import com.bcmc.xor.PipelineResult

node{
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work



           result = new  PipelineResult()
           result.setScript(this)
           result.success("test","test")
           result.print()
       }
}
