job('AdventureTime.Build') {
    description 'Build and test the app.'
    scm {
        git{
            remote {
               github 'NicolaiOksen/adventure-time'
               branch 'ready/**'
               name 'origin'
               credentials("2f0ddb6f-f67f-4c0b-9a17-09455139185c")
            }
            extensions {
                wipeOutWorkspace()
                pruneBranches()
            }
        }
        
    }
    wrappers {
        pretestedIntegration("SQUASHED", "master", "origin")
    }
    publishers {
        pretestedIntegration()
    }
    triggers {
        githubPush()
    }
    steps {
        shell('./test.sh')
    }
}