package system;

import com.mendix.core.actionmanagement.IActionRegistrator;

public class UserActionsRegistrar
{
  public void registerActions(IActionRegistrator registrator)
  {
    registrator.registerUserAction(compresspdf.actions.CompressPdf.class);
    registrator.registerUserAction(system.actions.VerifyPassword.class);
  }
}
