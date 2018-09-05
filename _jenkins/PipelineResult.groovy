import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson

class PipelineResult{

    def RESULTS_MAP = [:]

    PipelineResult()
    {
    }

    def checkAndCreate(def item)
    {
        RESULTS_MAP[item] = RESULTS_MAP."${item}"?:[:]
    }

    def success(def item, def stage, def msg=null)
    {
        checkAndCreate(item)
        RESULTS_MAP."${item}"["${stage}"] = resultSuccess(msg)
    }

    def warn(def item, def stage, def msg=null)
    {
        checkAndCreate(item)
        RESULTS_MAP."${item}"["${stage}"] = resultWarn(msg)
    }

    def failed(def item, def stage, def msg=null)
    {
        checkAndCreate(item)
        RESULTS_MAP."${item}"["${stage}"] = resultFailed(msg)
    }

    def print()
    {
        output.print "Results: ${RESULTS_MAP ? prettyPrint(toJson(RESULTS_MAP)) : "null"}"

    }

    def resultSuccess(String message=null){
        return "OK${message? " (${message})" : ""}"
    }

    def resultWarn(String message=null){
        return "WARN${message? " (${message})" : ""}"
    }

    def resultFailed(String message=null){
        return "FAIL${message? " (${message})" : ""}"
    }
}


return new PipelineResult();
