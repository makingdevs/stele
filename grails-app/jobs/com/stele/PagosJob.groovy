package com.stele

class PagosJob {
    static triggers = {
      cron name: 'pagosVencidos', cronExpression: "0 0 1 * * ?"
    }

    def execute() {
    }
}
