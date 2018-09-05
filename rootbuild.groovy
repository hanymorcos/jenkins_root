
String pipelinescript = "_jenkins/PipelineResult.groovy"

node('maven') {
       stage('github checkout') {
           cleanWs()
           checkout scm    // still needed, otherwise the following sh "git ..." commands will not work


           def pipeline = load pipelinescript

           pipeline.success("test","test")
           pipeline.print()
       }
}
