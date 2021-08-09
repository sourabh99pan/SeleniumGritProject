$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Guru/FreeCrmBDDFramework/src/main/java/Features/hooks.feature");
formatter.feature({
  "line": 1,
  "name": "Free ToolsQA app test",
  "description": "",
  "id": "free-toolsqa-app-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5022143800,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "free crm create deal test",
  "description": "",
  "id": "free-toolsqa-app-test;free-crm-create-deal-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is on toolsqa page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user fills the form",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "deal is created on toolsQA",
  "keyword": "Then "
});
formatter.match({
  "location": "Hooks_StepDefinition.User_is_accesing_ToolsQAe()"
});
formatter.result({
  "duration": 1103424800,
  "status": "passed"
});
formatter.match({
  "location": "Hooks_StepDefinition.user_fills_the_form()"
});
formatter.result({
  "duration": 6682500,
  "status": "passed"
});
formatter.match({
  "location": "Hooks_StepDefinition.deal_is_created_on_toolsQA()"
});
formatter.result({
  "duration": 608941600,
  "status": "passed"
});
formatter.after({
  "duration": 1130066900,
  "status": "passed"
});
});