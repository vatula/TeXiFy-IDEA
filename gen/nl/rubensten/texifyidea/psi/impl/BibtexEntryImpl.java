// This is a generated file. Not intended for manual editing.
package nl.rubensten.texifyidea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static nl.rubensten.texifyidea.psi.BibtexTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.rubensten.texifyidea.psi.*;

public class BibtexEntryImpl extends ASTWrapperPsiElement implements BibtexEntry {

  public BibtexEntryImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BibtexVisitor visitor) {
    visitor.visitEntry(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BibtexVisitor) accept((BibtexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<BibtexComment> getCommentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, BibtexComment.class);
  }

  @Override
  @NotNull
  public BibtexEndtry getEndtry() {
    return findNotNullChildByClass(BibtexEndtry.class);
  }

  @Override
  @Nullable
  public BibtexEntryContent getEntryContent() {
    return findChildByClass(BibtexEntryContent.class);
  }

  @Override
  @Nullable
  public BibtexId getId() {
    return findChildByClass(BibtexId.class);
  }

  @Override
  @Nullable
  public BibtexPreamble getPreamble() {
    return findChildByClass(BibtexPreamble.class);
  }

  @Override
  @NotNull
  public BibtexType getType() {
    return findNotNullChildByClass(BibtexType.class);
  }

}
