<%@ include file="header.jsp" %>
            <h4>Cr&eacute;er un Organisateur</h4>
            <div class="row">
              <form class="col s12">
                <div class="row">
                  <div class="input-field col s6">
                    <i class="material-icons prefix">group</i>
                    <input id="nomLieu" type="text" class="validate">
                    <label for="nomLieu">Nom du l'organisateur</label>
                  </div>
                  <div class="file-field input-field col s6">
                    <div class="btn">
                      <span>Logo</span>
                      <input type="file">
                    </div>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" type="text">
                    </div>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">home</i>
                    <input id="adresse" type="tel" class="validate">
                    <label for="adresse">Adresse</label>
                  </div>
                  <div class="input-field col s6">
                    <i class="material-icons prefix">phone</i>
                    <input id="prixentree" type="number" class="validate">
                    <label for="prixentree">T&eacute;l&eacute;phone</label>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">mail</i>
                    <input id="email" type="email" class="validate">
                    <label for="email">Email</label>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">http</i>
                    <input id="siteweb" type="text" class="validate">
                    <label for="siteweb">Site Web</label>
                  </div>
                  <div class="input-field col s12">
                    <i class="material-icons prefix">edit</i>
                    <textarea id="textarea1" class="materialize-textarea"></textarea>
                    <label for="textarea1">Description</label>
                  </div>
                  <div class="input-field col s12">
                    <button class="btn waves-effect waves-teal" type="submit" name="action">Cr&eacute;er
                      <i class="material-icons right">send</i>
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
<%@ include file="footer.jsp" %>