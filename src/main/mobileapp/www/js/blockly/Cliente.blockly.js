window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Cliente = window.blockly.js.blockly.Cliente || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.Cliente.autoCompletarEnderecoMobileArgs = [];
window.blockly.js.blockly.Cliente.autoCompletarEnderecoMobile = async function() {
 var dadosCEP;
  this.cronapi.util.getCEP(this.cronapi.screen.getValueOfField("Cliente.active.cep"), async function(sender_dadosCEP) {
      dadosCEP = sender_dadosCEP;
    this.cronapi.screen.changeValueOfField("Cliente.active.endereco", this.cronapi.json.getProperty(dadosCEP, 'logradouro'));
    this.cronapi.screen.changeValueOfField("Cliente.active.cidade", this.cronapi.json.getProperty(dadosCEP, 'localidade'));
    this.cronapi.screen.changeValueOfField("Cliente.active.uf", this.cronapi.json.getProperty(dadosCEP, 'uf'));
  }.bind(this));
}
